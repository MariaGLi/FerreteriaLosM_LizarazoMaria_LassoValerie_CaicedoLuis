package com.toolshare.toolshare.Application.Service;

import java.util.List;

import com.toolshare.toolshare.Domain.DamageReport;
import com.toolshare.toolshare.Domain.dto.DamageReportDto;
import com.toolshare.toolshare.Domain.request.DamageReportUpdateRequest;
import com.toolshare.toolshare.Domain.response.DamageReportResponse;
import com.toolshare.toolshare.Domain.response.DamageReportUpdateResponse;

public interface DamageReportService {
    DamageReport newReport(DamageReportDto dReportDto);
    List<DamageReportResponse> findAllReports();
    DamageReportUpdateResponse updateDamageReport(DamageReportUpdateRequest damageReport);
}
