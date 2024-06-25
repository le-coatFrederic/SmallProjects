package domains.usecase.text;

import domains.entities.text.Text;
import domains.usecase.text.type.DTOTextOperationOccurence;

public interface ITextOperation {
	public DTOTextOperationOccurence searchOccurence(Text toLookUp, Text toLookIn);
}
