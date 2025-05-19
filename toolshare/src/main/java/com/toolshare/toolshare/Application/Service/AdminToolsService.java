package com.toolshare.toolshare.Application.Service;

import java.util.List;

import com.toolshare.toolshare.Domain.response.StatusToolsResponse;

public interface AdminToolsService {
    List<StatusToolsResponse> findStatusTools();
}
