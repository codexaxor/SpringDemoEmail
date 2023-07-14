package io.getarrays.userservice.service;

import io.getarrays.userservice.controller.dto.SendMailResponseBody;

/**
 * @author Junior RT
 * @version 1.0
 * @license Get Arrays, LLC (https://getarrays.io)
 * @since 6/25/2023
 */

public interface EmailService {
    SendMailResponseBody sendSimpleMailMessage(String name, String to);
}