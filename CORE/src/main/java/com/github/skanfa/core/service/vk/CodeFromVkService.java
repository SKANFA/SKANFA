package com.github.skanfa.core.service.vk;

import com.github.skanfa.core.libs.locallibs.objects.vk.VkCode;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.springframework.stereotype.Service;

@Service
@Path("/codeFromVk")
public class CodeFromVkService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public VkCode codeFromVk(@QueryParam("code") @NotNull String code) {
        VkCode vkcode = new VkCode();
        vkcode.setCode(code);
        return vkcode;
    }
}
