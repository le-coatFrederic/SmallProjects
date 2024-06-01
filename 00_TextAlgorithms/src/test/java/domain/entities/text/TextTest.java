package domain.entities.text;

import static org.junit.Assume.assumeNoException;
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import domains.entities.text.Text;

class TextTest {
	@Test
	void testCreateTest() {
		String id = UUID.randomUUID().toString();
		String textString = new String("Il était une fois, un petit garçon.");
		Text text = new Text(id, null);
		
		text.getId();
		text.getValue();
	}
	
	@Test
	void textSetValue() {
		Text text = new Text(UUID.randomUUID().toString(), null);
		text.setValue("");
		System.out.println(text);
		text.setValue("Il était un petit ange nommé Nathan");
		System.out.println(text);
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			text.setValue(null);
		});
	}
	
	@Test
	void textSetId() {
		Text text = new Text(UUID.randomUUID().toString(), null);
		text.setId(UUID.randomUUID().toString());
		System.out.println(text.getId());
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			text.setId(null);
		});
	}
	
	@Test
	void textToString() {
		Text text = new Text(UUID.randomUUID().toString(), null);
		System.out.println(text);
	}
}
