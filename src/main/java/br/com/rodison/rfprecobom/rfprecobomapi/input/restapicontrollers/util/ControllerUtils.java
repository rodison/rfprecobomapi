package br.com.rodison.rfprecobom.rfprecobomapi.input.restapicontrollers.util;

import br.com.rodison.rfprecobom.rfprecobomapi.exceptions.RfPrecoBomException;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

import static br.com.rodison.rfprecobom.rfprecobomapi.exceptions.RfPrecoBomException.createUnknownException;

public class ControllerUtils {

	public static ResponseEntity<Object> handleControllerExceptions(Logger logger, Class<?> className, String methodName, Exception e) {
		if (e instanceof RfPrecoBomException) {
			logger.error(((RfPrecoBomException) e).toJson());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(((RfPrecoBomException) e).toJson());
		}
		RfPrecoBomException exception = createUnknownException(className, methodName, new HashMap<>());
		logger.error(exception.toJson());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.toJson());
	}

}
