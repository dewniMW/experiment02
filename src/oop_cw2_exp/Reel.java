package oop_cw2_exp;

import java.util.ArrayList;
public class Reel implements Runnable {
	ArrayList <ISymbol> symbolList= new ArrayList<>();
	ISymbol bell= new Symbol();
	ISymbol cherry= new Symbol();
	ISymbol lemon= new Symbol();
	ISymbol plum= new Symbol();
	ISymbol redseven= new Symbol();
	ISymbol watermelon= new Symbol();
	ISymbol imagePath = null;
	
	Reel(){
		bell.setImage("src\\oop_cw2_exp\\newbell.PNG");
		bell.setValue(6);
		cherry.setImage("src\\oop_cw2_exp\\newcherry.PNG");
		cherry.setValue(2);
		lemon.setImage("src\\oop_cw2_exp\\newlemon.PNG");
		lemon.setValue(3);
		plum.setImage("src\\oop_cw2_exp\\newplum.PNG");
		plum.setValue(4);
		redseven.setImage("src\\oop_cw2_exp\\newredseven.PNG");
		redseven.setValue(7);
		watermelon.setImage("src\\oop_cw2_exp\\newwatermelon.PNG");
		watermelon.setValue(5);
		symbolList.add(bell);
		symbolList.add(cherry);
		symbolList.add(lemon);
		symbolList.add(plum);
		symbolList.add(redseven);
		symbolList.add(watermelon);
	}
	

	public ISymbol spin(){
		return imagePath;
	}

	@Override
	public void run() {
		int n1 = (int) Math.floor(Math.random()*6);
		if (n1==0){
			imagePath=bell;
		}else if (n1==1){
			imagePath=cherry;
		}else if (n1==2){
			imagePath=lemon;
		}else if (n1==3){
			imagePath=plum;
		}else if (n1==4){
			imagePath=redseven;
		}else if (n1==5){
			imagePath=watermelon;
		}
	}

}