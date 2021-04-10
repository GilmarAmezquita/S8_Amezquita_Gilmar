package model;

public class Person {
	private long identification;
	private DocumentType idType;
	
	public Person(long id, int dType) {
		identification = id;
		setDocumentType(dType);
	}
	private void setDocumentType(int dType) {
		switch(dType) {
			case 1:
				idType = DocumentType.TI;
				break;
			case 2:
				idType = DocumentType.CC;
				break;
			case 3:
				idType = DocumentType.PP;
				break;
			case 4:
				idType = DocumentType.CE;
				break;
		}
	}
	public long getIdentification() {
		return identification;
	}
	public String getDocumentType() {
		return idType.toString();
	}
	public String getInfo() {
		String info = "";
		info += "********************\n";
		info += "** Document: "+getDocumentType()+"\n";
		info += "** Id: "+getIdentification()+"\n";
		return info;
	}
}
