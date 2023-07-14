package io.getarrays.userservice.service;

/**
 * @author Junior RT
 * @version 1.0
 * @license Get Arrays, LLC (https://getarrays.io)
 * @since 6/25/2023
 */

public interface EmailService {
    void sendSimpleMailMessage(String name, String to);
}