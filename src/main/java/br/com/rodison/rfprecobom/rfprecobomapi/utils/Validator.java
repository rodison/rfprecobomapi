package br.com.rodison.rfprecobom.rfprecobomapi.utils;

import br.com.rodison.rfprecobom.rfprecobomapi.exceptions.ErrorCodeEnum;
import br.com.rodison.rfprecobom.rfprecobomapi.exceptions.RfPrecoBomException;

import java.util.Objects;
import java.util.UUID;

import static br.com.rodison.rfprecobom.rfprecobomapi.exceptions.ErrorCodeEnum.FIELD_CANNOT_BE_NULL;
import static br.com.rodison.rfprecobom.rfprecobomapi.exceptions.ErrorCodeEnum.FIELD_MUST_BE_NULL;
import static br.com.rodison.rfprecobom.rfprecobomapi.exceptions.RfPrecoBomException.throwException;
import static br.com.rodison.rfprecobom.rfprecobomapi.utils.BuildMap.map;
import static br.com.rodison.rfprecobom.rfprecobomapi.utils.StringUtils.getString;

public class Validator {

	public static void requireNonNull(Class<?> sourceClass, String methodName, Object value, String fieldName) {
		if (value == null) {
			throwException(sourceClass, methodName, FIELD_CANNOT_BE_NULL, "Field cannot be null", map("fieldName", fieldName));
		}
	}

	public static void requireNull(Class<?> sourceClass, String methodName, Object value, String fieldName) {
		if (value == null) {
			throwException(sourceClass, methodName, FIELD_MUST_BE_NULL, "Field must be null", map("fieldName", fieldName).with("value", value.toString()));
		}
	}

	public static void requireIdEqualsInObject(Class<?> sourceClass, String methodName, UUID uuid, UUID uuidInObject, String uuidFieldName, String uuidFieldNameInObject) {
		if (!Objects.equals(uuid, uuidInObject)) {
			throw RfPrecoBomException.createException(sourceClass, methodName, ErrorCodeEnum.ID_IS_DIFFERENT_IN_OBJECT,
					uuidFieldName + " is different from " + uuidFieldNameInObject,
					BuildMap.map(uuidFieldName, getString(uuid)).with(uuidFieldNameInObject, getString(uuidInObject)));
		}
	}

}
