package oop_cw2_exp;

public class Symbol implements ISymbol{
String img;
int value;
	@Override
	public void setImage(String i) {
		this.img= i;
	}

	@Override
	public String getImage() {
		return img;
	}

	@Override
	public void setValue(int v) {
		this.value=v;
	}

	@Override
	public int getValue() {
		return value;
		
	}

	

}
