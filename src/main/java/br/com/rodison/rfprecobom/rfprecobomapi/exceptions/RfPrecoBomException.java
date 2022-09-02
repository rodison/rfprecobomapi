package br.com.rodison.rfprecobom.rfprecobomapi.exceptions;

import br.com.rodison.rfprecobom.rfprecobomapi.utils.BuildMap;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

import static br.com.rodison.rfprecobom.rfprecobomapi.utils.StringUtils.getString;

@Getter
@Setter
public class RfPrecoBomException extends RuntimeException {

	private Class<?> className;
	private String methodName;
	private ErrorCodeEnum errorCode;
	private Map<String, String> arguments = new HashMap<>();

	private RfPrecoBomException() {
		super();
	}

	private RfPrecoBomException(String message) {
		super(message);
	}

	public RfPrecoBomException(Class<?> className, String methodName, ErrorCodeEnum errorCode, String message, Map<String, String> arguments) {
		this(message);
		this.className = className;
		this.methodName = methodName;
		this.errorCode = errorCode;
		this.arguments = arguments;
	}

	public static void throwException(Class<?> className, String methodName, ErrorCodeEnum errorCode, String message, Map<String, String> arguments) {
		throw createException(className, methodName, errorCode, message, arguments);
	}

	public static RfPrecoBomException createException(Class<?> className, String methodName, ErrorCodeEnum errorCode, String message, Map<String, String> arguments) {
		return new RfPrecoBomException(className, methodName, errorCode, message, arguments);
	}

	public static RfPrecoBomException createObjectDoesNotExistsException(Class<?> className, String methodName, Object value, String fieldName) {
		return RfPrecoBomException.createException(className, methodName, ErrorCodeEnum.OBJECT_DOES_NOT_EXISTS, "Object does not exists",
				BuildMap.map("fieldName", fieldName).with("value", getString(value)));
	}

	public static RfPrecoBomException createUnknownException(Class<?> className, String methodName, Map<String, String> arguments) {
		return RfPrecoBomException.createException(className, methodName, ErrorCodeEnum.UNKNOWN_EXCEPTION, "Unknown Exception", arguments);
	}

	@Override
	public String toString() {
		return "\"error\": {" +
				"  \"className\": \"" + className + "\", " +
				"  \"methodName\": \"" + methodName + "\", " +
				"  \"errorCode\": \"" + errorCode + "\", " +
				"  \"message\": \"" + getMessage() + "\", " +
				"  \"arguments\": \"" + arguments + "\"}" +
				"}";
	}

	public String toJson() {
		return toString();
	}
}
