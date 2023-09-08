package helmes.back.configuration;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class SessionController {

    @PostMapping("/create-session")
    public ResponseEntity<Map<String, Object>> createSession(HttpSession session) {
        return ResponseEntity.ok(Collections.singletonMap("sessionId", session.getId()));
    }
}
