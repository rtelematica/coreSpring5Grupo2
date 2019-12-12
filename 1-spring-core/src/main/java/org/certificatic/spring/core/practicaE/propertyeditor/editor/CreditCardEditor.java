package org.certificatic.spring.core.practicaE.propertyeditor.editor;

import org.certificatic.spring.core.practicaE.propertyeditor.bean.CreditCard;
import org.springframework.util.StringUtils;

// Extiende PropertyEditorSupport
public class CreditCardEditor {

	public CreditCard parseCreditCardFromText(String text) {
		if (StringUtils.isEmpty(text)) {

			return null;

		} else {

			CreditCard.CreditCardBuilder creditCardBuilder = CreditCard.builder();

			creditCardBuilder.rawCardNumber(text);

			String cardNo = text.replaceAll("-", "");

			if (cardNo.length() != 16)
				throw new IllegalArgumentException("Invalid credit card format, should be: xxxx-xxxx-xxxx-xxxx");

			try {
				creditCardBuilder.bankIdNo(Integer.valueOf(cardNo.substring(0, 6)))
						.accountNo(Integer.valueOf(cardNo.substring(6, cardNo.length() - 1)))
						.checkCode(Integer.valueOf(cardNo.substring(cardNo.length() - 1)));

			} catch (NumberFormatException nfe) {
				throw new IllegalArgumentException(nfe);
			}

			return creditCardBuilder.build();
		}
	}
}