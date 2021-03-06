package me.daddychurchill.CityWorld.Plats.Urban;

import me.daddychurchill.CityWorld.CityWorldGenerator;
import me.daddychurchill.CityWorld.Plats.FinishedBuildingLot;
import me.daddychurchill.CityWorld.Plats.PlatLot;
import me.daddychurchill.CityWorld.Plugins.RoomProvider;
import me.daddychurchill.CityWorld.Rooms.Populators.*;
import me.daddychurchill.CityWorld.Support.PlatMap;
import me.daddychurchill.CityWorld.Support.SupportBlocks;

public class LibraryBuildingLot extends FinishedBuildingLot {

    private static final RoomProvider contentsRandom = new LibraryWithRandom();
    private static final RoomProvider contentsNoBooks = new LibraryWithNoBooks();
    private static final RoomProvider contentsSomeBooks = new LibraryWithSomeBooks();
    private static final RoomProvider contentsMostlyBooks = new LibraryWithMostlyBooks();
    private static final RoomProvider contentsAllBooks = new LibraryWithAllBooks();
    private static final RoomProvider contentsLounges = new LibraryWithLounges();

    public LibraryBuildingLot(PlatMap platmap, int chunkX, int chunkZ) {
        super(platmap, chunkX, chunkZ);
        // TODO Auto-generated constructor stub
    }

    @Override
    public RoomProvider roomProviderForFloor(CityWorldGenerator generator, SupportBlocks chunk, int floor, int floorY) {
        if (floor == 0)
            return contentsLounges;
        else
            switch (chunkOdds.getRandomInt(5)) {
                case 1:
                    return contentsNoBooks;
                case 2:
                    return contentsSomeBooks;
                case 3:
                    return contentsMostlyBooks;
                case 4:
                    return contentsAllBooks;
                default:
                    return contentsRandom;
            }
    }

    @Override
    protected InteriorStyle getFloorsInteriorStyle(int floor) {
        if (floor == 0)
            return InteriorStyle.COLUMNS_OFFICES;
        else
            return super.getFloorsInteriorStyle(floor);
    }

    @Override
    protected InteriorStyle pickInteriorStyle() {
        switch (chunkOdds.getRandomInt(10)) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return InteriorStyle.COLUMNS_OFFICES;
            case 9:
            default:
                return InteriorStyle.COLUMNS_ONLY;
        }
    }

    @Override
    public PlatLot newLike(PlatMap platmap, int chunkX, int chunkZ) {
        return new LibraryBuildingLot(platmap, chunkX, chunkZ);
    }

}
