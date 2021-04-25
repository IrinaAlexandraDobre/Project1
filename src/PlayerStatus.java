
public class PlayerStatus {

	// Stare interna

	private final String nickname; // un sir de caractere, ce semnifica numele jucatorului
	private int score; // un numar intreg, ce reprezinta scorul jucatorului
	private int lives; // un numar intreg, ce simbolizeaza numarul de vieti al jucatorului
	private int health; // un numar intreg, intre 0 si 100, ce reprezinta procentul de viata ramas
	private String weaponInHand; // un sir de caractere ce simbolizeaza arma jucatorului
	private double positionX; // coordonata OX a pozitiei jucatorului, o valoare numerica reala
	private double positionY;// coordonata OY a pozitiei jucatorului, o valoare numerica reala
	private static String gameName; // numele jocului-valoare unica pentru toate obiectele
    
	// Comportament

	// metode de initializare
	public PlayerStatus(String nickname) {
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}

	public PlayerStatus(String nickname, int lives) {
		this(nickname);
		this.lives = lives;
	}

	public PlayerStatus(String nickname, int lives, int score) {
		this(nickname);
		this.lives = lives;
		this.score = score;
	}
	// metode setter si getter pentru score

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}
	
	// metode setter si getter pentru health-are valori intre 0 si 100
	public void setHealth(int health) {
		if (health <= 0) {
			setLives(lives - 1);
			this.health = 100;
		} else if (health > 100) {
			this.health = 100;
		} else {
			this.health = health;
		}
	}

	public int getHealth() {
		return health;
	}
    
	// metode setter si getter pentru lives
	public void setLives(int lives) {
		this.lives = lives;
	}

	public int getLives() {
		return lives;
	}

	// metode setter si getter pentru positionX si positionY
	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}

	public double getPositionX() {
		return positionX;
	}

	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}

	public double getPositionY() {
		return positionY;
	}
	
    //metoda care seteaza numele jocului
	public static void setGameName(String newGameName) {
		gameName = newGameName;
	}

	public static String getGameName() {
		return gameName;
	}

	// metoda actualizeaza pozitia jucatorului,
	public void movePlayerTo(double positionX, double positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	// metoda pentru suma cifrelor artifactului
	private int sumArtifactDigits(int artifactCode) {
		int sumArtifactD = 0;
		int copyCrt = artifactCode;
		while (copyCrt != 0) {
			if (copyCrt % 10 >= 0) {
				sumArtifactD += copyCrt % 10;
			}
			copyCrt /= 10;
		}
		return sumArtifactD;
	}
	
	// metoda pentru a verifica daca artifactul e numar prim
	private boolean artifactIsPrime(int artifactCode) {
		boolean isPrime1 = true;
			if (artifactCode == 2) {
				isPrime1 = true;
			} else if (artifactCode % 2 == 0) {
				isPrime1 = false;
			} else {
				for (int d1 = 2; d1 <= (artifactCode / 2); d1++) {
					if (artifactCode % d1 == 0) {
						isPrime1 = false;
					}
				}
			}
			return isPrime1;
	}
	
	// metoda pentru suma divizori artifact
	private int perfectNr(int artifactCode) {
		int sumNrPerfect = 0;
		int artifactCode1 = artifactCode;
	    for (int i1 = 1; i1 <= (artifactCode1 / 2); i1++) {
				if (artifactCode1 % i1 == 0) {
					sumNrPerfect += i1;
				}
			}
	    return sumNrPerfect;
	}

	// metoda pentru a actualiza starea jucatorului in functie de artifactul gasit

	public void findArtifact(int artifactCode) {
		if (artifactCode == perfectNr(artifactCode)) {
			 setScore(getScore() + 5000);
			 setLives(getLives() + 1);
			 setHealth(100);
			 System.out.println("Artifact is perfect number. " );
			 System.out.println("Score: " + getScore());
			 System.out.println("Lives: " + getLives());
			 System.out.println("Health: " + getHealth());
		} else if (artifactIsPrime(artifactCode) == true) {
			 setScore(getScore() + 1000);
			 setLives(getLives() + 2);
			 setHealth(getHealth() + 25);
			 System.out.println("Artifact is prime. " );
			 System.out.println("Score: " + getScore());
			 System.out.println("Lives: " + getLives());
			 System.out.println("Health: " + getHealth());
		} else if ((artifactCode % 2 == 0) && (sumArtifactDigits(artifactCode) % 3 == 0)) {
			 setScore(getScore() - 3000);
			 setHealth(getHealth() - 25);
			if ( getHealth() == 0) {
				 setLives(getLives() - 1); //daca health ajunge la 0 scade numarul de vieti
				 setHealth(100);
			}
			 System.out.println("Artifact is divisible by 2 and the sum of the digits is divisible by 3.");
			 System.out.println("Score: " + getScore());
			 System.out.println("Lives: " + getLives());
			 System.out.println("Health: " + getHealth());
		} else {
			 setScore(artifactCode);
			 System.out.println("Score: " + getScore());
		}
		 if(getLives() == 0) {
			 System.out.println("Game over"); 
		 }
	}

	// metoda setWeaponInHand() va schimba arma folosita de jucator in joc
	int weaponPriceKnife = 1000;
	int weaponPriceSniper = 10000;
	int weaponPriceKalashnikov = 20000;
	String weapon1 = "knife";
	String weapon2 = "sniper";
	String weapon3 = "kalashnikov";
	
	public String getWeaponInHand() {
		return weaponInHand;
	}
     // se verifica daca numele armei e introdus corect si daca jucatorul are scorul suficient pentru achizitie
	public boolean setWeaponInHand(String weaponInHand) {
		if ((weaponInHand.equals(weapon1)) && (getScore() >= weaponPriceKnife)) {
			this.weaponInHand = weaponInHand;
			setScore(score - weaponPriceKnife);
			System.out.println("Weapon in hand: " + getWeaponInHand());
			return true;
		} else if ((weaponInHand.equals(weapon2)) && (getScore() >= weaponPriceSniper)) {
			this.weaponInHand = weaponInHand;
			System.out.println("Weapon in hand: " + getWeaponInHand());
			setScore(score - weaponPriceSniper);
			return true;
		} else if ((weaponInHand.equals(weapon3)) && (getScore() >= weaponPriceKalashnikov)) {
			this.weaponInHand = weaponInHand;
			System.out.println("Weapon in hand: " + getWeaponInHand());
			setScore(score - weaponPriceKalashnikov);
			return true;
		} else {
			System.out.println("Error");
			return false;
		}
	}
	
	//metoda care calculeaza distanta
	
	private double distance(PlayerStatus oponent) {
		double distanceBetweenPlayers = Math
				.sqrt(Math.pow((this.getPositionX() - oponent.getPositionX()), 2) + Math.pow((this.getPositionY() -  oponent.getPositionY()), 2));
		return  distanceBetweenPlayers;
	}
	
	
	
	//cazul in care ambii jucatori au aceeasi arma
		private boolean attackOponent1(PlayerStatus oponent) {
			double probabilitateCastig1 = (3 * this.getHealth() + this.getScore() / 1000) / 4;
			double probabilitateCastig2 = (3 * oponent.getHealth() + oponent.getScore() / 1000) / 4;
			System.out.println("Probabilitate castig player1:");
			System.out.println(probabilitateCastig1);
			System.out.println("Probabilitate castig oponent:");
			System.out.println(probabilitateCastig2);
			if (probabilitateCastig1 > probabilitateCastig2) {
				return true;
			} else {
				return false;
			}
			
		}
	
	//armele sunt diferite si distanta e mai mare decat 1000- sniper > kalashnikov > knife
	private boolean attackOponent2(PlayerStatus oponent) {
		if (this.getWeaponInHand().equals("sniper")) {
			return true;
		} else if (oponent.getWeaponInHand().equals("sniper")) {
			return false;
		} else if ((this.getWeaponInHand().equals("kalashnikov")) && (oponent.getWeaponInHand().equals("knife"))) {
			return true;
		} else if ((oponent.getWeaponInHand().equals("kalashnikov")) && (this.getWeaponInHand().equals("knife"))) {
			return false;
		} else if (this.getWeaponInHand().equals("knife")) {
			return false;
		} else if (oponent.getWeaponInHand().equals("knife")) {
			return true;
		} else {
			System.out.println("Error!");
			return false;
			
		}
		
	}
	
	//armele sunt diferite si distanta e mai mica decat 1000- kalashnikov > sniper > knife
	private boolean attackOponent3(PlayerStatus oponent) {
		if (this.getWeaponInHand().equals("kalashnikov")) {
			return true;
		} else if (oponent.getWeaponInHand().equals("kalashnikov")) {
			return false;
		} else if ((this.getWeaponInHand().equals("sniper")) && (oponent.getWeaponInHand().equals("knife"))) {
			return true;
		} else if ((oponent.getWeaponInHand().equals("sniper")) && (this.getWeaponInHand().equals("knife"))) {
			return false;
		} else if (this.getWeaponInHand().equals("knife")) {
			return false;
		} else if (oponent.getWeaponInHand().equals("knife")) {
			return true;
		}else {
			System.out.println("Error!");	
			return false;
		}
		
		
	}

	//metoda mesaj simulare -afiseaza un mesaj in functie de valoarea obtinuta in metodele anterioare
	public void message1(boolean message) {
	   if(message == true) {
		System.out.println("Player1 will win!");
	} else if(message == false) {
		System.out.println("Player1 will lose!");
	}
	}
	
	//metoda care silmuleaza duelul
	//in functie de caz apelez metodele attackOponent1,attackOponent2 sau attackOponent3 ca argument pentru message1
	public boolean shouldAttack(PlayerStatus oponent) {
		if (this.getWeaponInHand().equals(oponent.getWeaponInHand())) {
			message1(attackOponent1(oponent));
			return attackOponent1(oponent);
		} 
		else if (!this.getWeaponInHand().equals(oponent.getWeaponInHand())) {
			if (distance(oponent) > 1000) {
				message1(attackOponent2(oponent));
				return attackOponent2(oponent);
		    }else if (distance(oponent) <= 1000) {
		    	message1(attackOponent3(oponent));
				return attackOponent3(oponent);

		    } else {
			System.out.println("Error!");
			return false;
		}
		} else {
			System.out.println("Error!");
			return false;
		}
	}
	
	
	//afisare mesaj duel- scade numarul de vieti
		public void message2(boolean message2, PlayerStatus oponent ) {
		   if(message2 == true) {
			System.out.println("Player1 won!");
			oponent.setLives(oponent.getLives() - 1);
			oponent.setHealth(100);
		} else if(message2 == false) {
			System.out.println("Player1 lost!");
			setLives(this.getLives() - 1);
			this.setHealth(100);
		}
		   if((oponent.getLives() == 0) ||(this.getLives() == 0)) {
				 System.out.println("Game over"); 
			 }
		}
		
	
	//metoda pentru duel
	public boolean attackOponent(PlayerStatus oponent) {
		if (this.getWeaponInHand().equals(oponent.getWeaponInHand())) {
			message2(attackOponent1(oponent),oponent);
			return attackOponent1(oponent);
		} else if (!this.getWeaponInHand().equals(oponent.getWeaponInHand())) {
			if (distance(oponent) > 1000) {
				message2(attackOponent2(oponent),oponent);
				return attackOponent2(oponent);
		    }else if (distance(oponent) <= 1000) {
		    	message2(attackOponent3(oponent),oponent);
				return attackOponent3(oponent);
		} else {
			System.out.println("Error!");
			return false;
		}
		} else {
			System.out.println("Error!");
			return false;
		}
	}
	
	//metoda pentru afisare
	public void showStatus() {
		System.out.println("Name: " + getNickname());
		System.out.println("Score: " + getScore());
		System.out.println("Weapon in hand: " + getWeaponInHand());
		System.out.println("Health: " + getHealth());
		System.out.println("Lives: " + getLives());
		System.out.println("PositionX: " + getPositionX());
		System.out.println("PositionY: " + getPositionY());
	}
	
}
		  

