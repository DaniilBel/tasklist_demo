package org.project.tasklist_demo.service;

import org.project.tasklist_demo.web.dto.auth.JwtRequest;
import org.project.tasklist_demo.web.dto.auth.JwtResponse;

public interface AuthService {

    JwtResponse login(
            JwtRequest loginRequest
    );

    JwtResponse refresh(
            String refreshToken
    );

}
