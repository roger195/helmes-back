package helmes.back.personsectorsinfo;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person-sectors-info")
public class PersonSectorsInfoController {


    private final PersonSectorsInfoService personSectorsInfoService;

    public PersonSectorsInfoController(PersonSectorsInfoService personSectorsInfoService) {
        this.personSectorsInfoService = personSectorsInfoService;
    }

    @GetMapping
    public PersonSectorsInfoDTO getPersonSectorsInfo(@RequestHeader("SessionId") String sessionId) {
        return personSectorsInfoService.getPersonSectorsInfo(sessionId);
    }

    @PostMapping
    public ResponseEntity<?> savePersonSectorsInfo(@Valid @RequestBody PersonSectorsInfoDTO personSectorsInfo,
                                                @RequestHeader("SessionId") String sessionId,
                                                   Errors errors) {
        if (errors.hasErrors()) {
            return new ResponseEntity(errors, HttpStatus.BAD_REQUEST);
        }
        personSectorsInfoService.savePersonSectorsInfo(personSectorsInfo, sessionId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
