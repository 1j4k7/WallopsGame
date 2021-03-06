package com.wallops.java.reference;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wallops.java.event.Game;

public enum Move {
	NONE(),
	//(name, type, category, pp, power, accuracy%)
	EMBER("Ember", Type.FIRE, Move.SPECIAL, 25, 40, 100),
	FLAMETHROWER("Flamethrower", Type.FIRE, Move.SPECIAL, 15, 90, 100),
	WATER_GUN("Water_Gun", Type.WATER, Move.SPECIAL, 25, 40, 100),
	WITHDRAW("Withdraw", Type.WATER, Move.STATUS_SELF, 40, -1, -1),
	ABSORB("Absorb", Type.GRASS, Move.SPECIAL, 25, 20, 100),
	AROMATHERAPY("Aromatherapy", Type.GRASS, Move.STATUS_SELF, 5, -1, -1),
	INGRAIN("Ingrain", Type.GRASS, Move.STATUS_SELF, 20, -1, -1),
	LEECH_SEED("Leech_Seed", Type.GRASS, Move.STATUS_OPPONENT, 10, -1, 90),
	MEGA_DRAIN("Mega_Drain", Type.GRASS, Move.SPECIAL, 15, 40, 100),
	SOLAR_BEAM("Solar_Beam", Type.GRASS, Move.SPECIAL, 10, 120, 100),
	STUN_SPORE("Stun_Spore", Type.GRASS, Move.STATUS_OPPONENT, 30, -1, 75),
	SYNTHESIS("Synthesis", Type.GRASS, Move.STATUS_SELF, 5, -1, -1),
	VINE_WHIP("Vine_Whip", Type.GRASS, Move.PHYSICAL, 25, 45, 100),
	DEFENSE_CURL("Defense_Curl", Type.NORMAL, Move.STATUS_SELF, 40, -1, -1),
	DISABLE("Disable", Type.NORMAL, Move.STATUS_OPPONENT, 20, -1, 100),
	DOUBLE_SLAP("Double_Slap", Type.NORMAL, Move.PHYSICAL, 10, 15, 85),
	ENCORE("Encore", Type.NORMAL, Move.STATUS_OPPONENT, 5, -1, 100),
	FOCUS_ENERGY("Focus_Energy", Type.NORMAL, Move.STATUS_SELF, 30, -1, -1),
	FORESIGHT("Foresight", Type.NORMAL, Move.STATUS_OPPONENT, 40, -1, -1),
	FURY_ATTACK("Fury_Attack", Type.NORMAL, Move.PHYSICAL, 20, 15, 85),
	GROWL("Growl", Type.NORMAL, Move.STATUS_OPPONENT, 40, -1, 100),
	HARDEN("Harden", Type.NORMAL, Move.STATUS_SELF, 30, -1, -1),
	LEER("Leer", Type.NORMAL, Move.STATUS_SELF, 30, -1, 100),
	METRONOME("Metronome", Type.NORMAL, Move.STATUS_OPPONENT, 10, -1, -1),//??????????!!?!?!?!??!?!??!?!
	MINIMIZE("Minimize", Type.NORMAL, Move.STATUS_SELF, 10, -1, -1),
	POUND("Pound", Type.NORMAL, Move.PHYSICAL, 35, 40, 100),
	QUICK_ATTACK("Quick_Attack", Type.NORMAL, Move.PHYSICAL, 30, 40, 100),
	SAFEGUARD("Safeguard", Type.NORMAL, Move.STATUS_SELF, 25, -1, -1),
	SCRATCH("Scratch", Type.NORMAL, Move.PHYSICAL, 35, 40, 100),
	SCREECH("Screech", Type.NORMAL, Move.STATUS_OPPONENT, 40, -1, 85),
	SING("Sing", Type.NORMAL, Move.STATUS_OPPONENT, 15, -1, 55),
	SLAM("Slam", Type.NORMAL, Move.PHYSICAL, 20, 80, 75),
	SMOKESCREEN("Smokescreen", Type.NORMAL, Move.STATUS_OPPONENT, 20, -1, 100),
	SPLASH("Splash", Type.NORMAL, Move.STATUS_SELF, 40, -1, -1),
	SUPERSONIC("Supersonic", Type.NORMAL, Move.STATUS_OPPONENT, 20, -1, 55),
	SWEET_SCENT("Sweet_Scent", Type.NORMAL, Move.STATUS_OPPONENT, 20, -1, 100),
	TACKLE("Tackle", Type.NORMAL, Move.PHYSICAL, 35, 50, 100),
	TAIL_WHIP("Tail_Whip", Type.NORMAL, Move.STATUS_OPPONENT, 30, -1, 100),
	WRAP("Wrap", Type.NORMAL, Move.PHYSICAL, 20, 15, 90),
	THUNDERBOLT("Thunderbolt", Type.ELECTRIC, Move.SPECIAL, 15, 90, 100),
	THUNDER_SHOCK("Thunder_Shock", Type.ELECTRIC, Move.SPECIAL, 30, 40, 100),
	BLIZZARD("Blizzard", Type.ICE, Move.SPECIAL, 5, 110, 70),
	BITE("Bite", Type.DARK, Move.PHYSICAL, 25, 60, 100),
	DOUBLE_KICK("Double_Kick", Type.FIGHTING, Move.PHYSICAL, 30, 30, 100),
	MACH_PUNCH("Mach_Punch", Type.FIGHTING, Move.PHYSICAL, 30, 40, 100),
	FLY("Fly", Type.FLYING, Move.PHYSICAL, 15, 90, 95),
	GUST("Gust", Type.FLYING, Move.SPECIAL, 35, 40, 100),
	PECK("Peck", Type.FLYING, Move.PHYSICAL, 35, 35, 100),
	ACID("Acid", Type.POISON, Move.SPECIAL, 30, 40, 100),
	POISON_FANG("Poison_Fang", Type.POISON, Move.PHYSICAL, 15, 50, 100),
	POISON_POWDER("Poison_Powder", Type.POISON, Move.STATUS_OPPONENT, 35, -1, 75),
	POISON_STING("Poison_Sting", Type.POISON, Move.PHYSICAL, 35, 15, 100),
	TOXIC("Toxic", Type.POISON, Move.STATUS_OPPONENT, 10, -1, 90),
	DIG("Dig", Type.GROUND, Move.PHYSICAL, 10, 80, 100),
	SAND_ATTACK("Sand-Attack", Type.GROUND, Move.STATUS_OPPONENT, 15, -1, 100),
	ROCK_THROW("Rock_Throw", Type.ROCK, Move.PHYSICAL, 15, 50, 90),
	BUG_BITE("Bug_Bite", Type.BUG, Move.PHYSICAL, 20, 60, 100),
	BUG_BUZZ("Bug_Buzz", Type.BUG, Move.SPECIAL, 10, 90, 100),
	STRING_SHOT("String_Shot", Type.BUG, Move.STATUS_OPPONENT, 40, -1, 95),
	INFESTATION("Infestation", Type.BUG, Move.SPECIAL, 20, 20, 100),
	LEECH_LIFE("Leech_Life", Type.BUG, Move.PHYSICAL, 15, 20, 100),
	IRON_HEAD("Iron_Head", Type.STEEL, Move.PHYSICAL, 15, 80, 100),
	DRAGON_CLAW("Dragon_Claw", Type.DRAGON, Move.PHYSICAL, 15, 80, 100),
	CONFUSION("Confusion", Type.PSYCHIC, Move.SPECIAL, 25, 50, 100),
	ASTONISH("Astonish", Type.GHOST, Move.PHYSICAL, 15, 30, 100),
	CONFUSE_RAY("Confuse_Ray", Type.GHOST, Move.STATUS_OPPONENT, 10, -1, 100),
	DISARMING_VOICE("Disarming_Voice", Type.FAIRY, Move.SPECIAL, 15, 40, -1)
	;
	
	public static final int NO = 0;
	public static final int PHYSICAL = 1;
	public static final int SPECIAL = 2;
	public static final int STATUS_OPPONENT = 3;
	public static final int STATUS_SELF = 4;
	
	private String name;
	private Type type;
	private int category;
	private int power;
	private int accuracy;
	private int maxPP;
	private int currentPP;
	private String description;
	
	private Move() {
		name = "";
		type = null;
		category = 0;
		maxPP = 0;
		power = 0;
		accuracy = 0;
		description = null;
	}
	
	private Move(String n, Type t, int c, int points, int p, int a) {
		name = n;
		type = t;
		category = c;
		maxPP = points;
		power = p;
		accuracy = a;
		
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(ResourcePath.resourceDir+"move_description.properties")));
		} catch (FileNotFoundException e) {
			Game.logger.fatal("Could not find properties file: ",e);
		} catch (IOException e) {
			Game.logger.fatal("Error while loading properties file in Move.java: ",e);
		}
		description = prop.getProperty(name);
	}
	
	public String getName() {
		String actualName = "";
		String[] words = name.split("_");
		for (int i = 0; i < words.length; i++) {
			actualName += words[i] + " ";
		}
		actualName = actualName.substring(0, actualName.length() - 1);
		return actualName;
	}
	
	public Type getType() {
		return type;
	}
	
	public int getCategory() {
		return category;
	}
	
	public int getPower() {
		return power;
	}
	
	public int getAccuracy() {
		return accuracy;
	}
	
	public int getMaxPP() {
		return maxPP;
	}
	
	public int getCurrentPP() {
		return currentPP;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public void setType(Type t) {
		type = t;
	}
	
	public void setCategory(int c) {
		category = c;
	}
	
	public void setPower(int p) {
		power = p;
	}
	
	public void setAccuracy(int a) {
		accuracy = a;
	}
	
	public void setMaxPP(int p) {
		maxPP = p;
	}
	
	public void setCurrentPP(int p) {
		currentPP = p;
	}
	
	public void setDescription(String d) {
		description = d;
	}
}
