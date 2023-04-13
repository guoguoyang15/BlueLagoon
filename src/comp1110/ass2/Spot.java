package comp1110.ass2;

public class Spot {

    public enum SettlerOrVillage{
        NULL,
        SETTLER,
        VILLAGE;
    }
    public int occupiedByPlayer;
    public int spotType;
    public Resource resources;
    public int island;//No. of island the spot belongs to
    public SettlerOrVillage settlerOrVillage;

    public Spot() {
        this.occupiedByPlayer=100;//there are players 0~3, at first nobody occupies this spot
        this.spotType=0;//We can change it later, those are still not changed will be sea
        this.resources=Resource.NULL;
        this.island=100;//we change it later
        this.settlerOrVillage=SettlerOrVillage.NULL;//At first nothing this spot
    }

    public int getOccupiedByPlayer() {
        return occupiedByPlayer;
    }

    public void setOccupiedByPlayer(int occupiedByPlayer) {
        this.occupiedByPlayer = occupiedByPlayer;
    }

    public int getSpotType() {
        return spotType;
    }

    public void setSpotType(int spotType) {
        this.spotType = spotType;
    }

    public Resource getResources() {
        return resources;
    }

    public void setResources(Resource resources) {
        this.resources = resources;
    }

    public int getIsland() {
        return island;
    }

    public void setIsland(int island) {
        this.island = island;
    }

    public SettlerOrVillage getSettlerOrVillage() {
        return settlerOrVillage;
    }

    public void setSettlerOrVillage(SettlerOrVillage settlerOrVillage) {
        this.settlerOrVillage = settlerOrVillage;
    }



    public static Player[] mojority(int island){

        return null;
    }
}
