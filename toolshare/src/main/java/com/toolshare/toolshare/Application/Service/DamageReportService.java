package com.toolshare.toolshare.Application.Service;

import com.toolshare.toolshare.Domain.DamageReport;
import com.toolshare.toolshare.Domain.dto.DamageReportDto;

public interface DamageReportService {
    DamageReport newReport(DamageReportDto dReportDto);
}
