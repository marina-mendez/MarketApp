package src.helpers;

public enum DescRec {

	TOMATE("tomate"), VENCIM("2022"), RECICLABLE("reciclables"), SEISC("600"), ARCOR("Arcor"), SETEC("700"), DOSC("200"), GOLOSINAS("Golosinas");
	
	private String desc;

	private DescRec(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
}