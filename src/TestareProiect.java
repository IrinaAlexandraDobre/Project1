
public class TestareProiect {

	public static void main(String[] args) {
		// Testare
		
		PlayerStatus.setGameName("Game 1");
		System.out.println(PlayerStatus.getGameName());
		
		//Se instantiaza clasa PlayerStatus
		//Se initializeaza numele, numarul de vieti si scorul pentru player1 si oponent
		System.out.println();
		PlayerStatus player1 = new PlayerStatus("player1", 3, 30000);
		System.out.println();
		PlayerStatus oponent = new PlayerStatus("oponent", 3, 30000);
		System.out.println();
		
		//Se initializeaza health pentru player1 si oponent
		player1.setHealth(100);
		oponent.setHealth(100);
		
		//Se initializeaza pozitiile pentru player1 si oponent
		player1.setPositionX(11.2);
		player1.setPositionY(22.3);
        oponent.setPositionX(15.2);
		oponent.setPositionY(32.1);
		
		//se afiseaza starea jucatorilor
		player1.showStatus();
		System.out.println();
		oponent.showStatus();
		System.out.println();
		
		
		//Se initializeaza armele jucatorilor
		player1.setWeaponInHand("kalashnikov");
		oponent.setWeaponInHand("knife");
		
		// va castiga player1 deoarece arma sa este mai puternica
		//cazul2: armele sunt diferite si distanta e mai mica decat 1000- kalashnikov > sniper > knife
		//lives pentru oponent ajunge la 2
		System.out.println();
		player1.shouldAttack(oponent);
		System.out.println();
		player1.attackOponent(oponent);
		System.out.println();
		
		player1.showStatus();
		System.out.println();
		oponent.showStatus();	
		System.out.println();

		
		//player1 gaseste un artifact care e numar perfect
		//score se incrementeaza cu 5000, lives creste cu 1 viata, health devine 100
		player1.findArtifact(6);
		//player1 gaseste un artifact care e numar prim
		//score se incrementeaza cu 1000, lives creste cu 2 viata, health creste cu 25
		System.out.println();
		player1.findArtifact(13);
		//player1 gaseste 4 artifacte pare si cu suma cifrelor divizibila cu 3
		//score se decrementeaza cu 3000, health se decrementeaza cu 25(de 4 ori) si ajunge la 0
		//astfel ca lives scade cu 1
		System.out.println();
		player1.findArtifact(12);
		System.out.println();
		player1.findArtifact(18);
		System.out.println();
		player1.findArtifact(24);
		System.out.println();
		player1.findArtifact(36);
		System.out.println();
		
		player1.showStatus();
		System.out.println();
		oponent.showStatus();	
		System.out.println();
		
		//castiga player1
		//lives pentru oponent ajunge la 1
		player1.shouldAttack(oponent);
		System.out.println();
		player1.attackOponent(oponent);
		System.out.println();
		
		//se schimba coordonatele jucatorilor
		player1.movePlayerTo(14.2, 31.2);
		oponent.movePlayerTo(40.1,11.3);
		
		//arma oponentului devine sniper
		//cazul2: armele sunt diferite si distanta e mai mica decat 1000- kalashnikov > sniper > knife
		//castiga player1
		oponent.setWeaponInHand("sniper");
		System.out.println();
		//lives pentru oponent ajunge la 0
		//game over
		player1.shouldAttack(oponent);
		System.out.println();
		player1.attackOponent(oponent);

	}
}
