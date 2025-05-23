package com.toolshare.toolshare.Infraestructure.Repository.RepositoryIMPL;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import com.toolshare.toolshare.Application.Service.invoiceservice;
import com.toolshare.toolshare.Domain.Invoices;
import com.toolshare.toolshare.Infraestructure.Repository.InvoicesRepository;

@Service
public class invoiceImpl implements invoiceservice{

    @Autowired
    private InvoicesRepository invoicesRepository;

    @Override
    public byte[] pdf(Long id) throws IOException {
        Invoices invoice= getInvoiceById(id);
        String htmlTemplate= new String(getClass().getResourceAsStream("/templates/invoice.html").readAllBytes(), StandardCharsets.UTF_8);

        String toolsR= invoice.getTool_invoice_list().stream().map(tool-> String.format(("""
                    <tr>
                        <td>%s</td>
                        <td>%s</td>
                        <td>$%.2f</td>
                    </tr>
                """), tool.getQuantity(), tool.getToolsEquipmentConstruction().getName(), tool.getTotal_value(), tool.getUnit_value())).collect(Collectors.joining());
        String htmlField= htmlTemplate
            .replace("[[id]]", invoice.getNumber_invoice().toString())
            .replace("[[clientName]]", invoice.getId_client().getName())
            .replace("[[clientLastname]]", invoice.getId_client().getLast_name())
            .replace("[[clientPhone]]", invoice.getCellphone())
            .replace("[[dateGeneration]]", invoice.getRegistration_date().toString())
            .replace("[[dateExpiration]]", invoice.getExpiration_date().toString())
            .replace("[[tools]]", toolsR)
            .replace("[[name]]", invoice.getName_tool_share())
            .replace("[[nit]]", invoice.getNit())
            .replace("[[address]]", invoice.getAddress())
            .replace("[[method]]", invoice.getId_payments().getPayment_method())
            .replace("[[datePayment]]", invoice.getId_payments().getPayment_date().toString())
            .replace("[[statusPayment]]", invoice.getId_payments().getStatus().toString())
            .replace("[[startDate]]", invoice.getId_payments().getId_reservations().getStart_date().toString())
            .replace("[[endDate]]", invoice.getId_payments().getId_reservations().getEnd_date().toString())
            .replace("[[total]]", String.format("%.2f", invoice.getAnd_total()));

            System.out.println("Html Generated");
            System.out.println(htmlField); // html invoice
            try (ByteArrayOutputStream os= new ByteArrayOutputStream()){
                PdfRendererBuilder builder= new PdfRendererBuilder();
                builder.withHtmlContent(htmlField, null);
                builder.toStream(os);
                builder.run();
                return os.toByteArray();
            } catch (Exception e) {
                throw new RuntimeException("Error", e);
            }
    }


    @Override
    public Invoices getInvoiceById(Long id) {
        return invoicesRepository.findById(id).orElseThrow(()-> new RuntimeException("Invoice not found"));
    }

}
