package com.demo.app.ws.controller.v1;

import com.demo.app.ws.dto.responses.PaginationResponse;
import com.demo.app.ws.services.AgentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/agents")
@AllArgsConstructor
public class AgentController {
    private AgentService agentService;

    @GetMapping("/{companyPublicId}")
    public PaginationResponse getAgentsByCompanyAdmin(
            @PathVariable String companyPublicId,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "5") int limit
    ) {
        return agentService.getAgentsByCompanyAdmin(companyPublicId, page, limit);
    }

}
