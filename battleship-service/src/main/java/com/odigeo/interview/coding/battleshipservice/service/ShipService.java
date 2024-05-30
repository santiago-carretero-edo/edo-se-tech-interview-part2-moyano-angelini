package com.odigeo.interview.coding.battleshipservice.service;

import com.odigeo.interview.coding.battleshipapi.contract.DeployShipsCommand;
import com.odigeo.interview.coding.battleshipservice.model.Coordinate;
import com.odigeo.interview.coding.battleshipservice.model.Game;
import com.odigeo.interview.coding.battleshipservice.model.ship.Ship;
import com.odigeo.interview.coding.battleshipservice.model.ship.ShipType;

import java.util.ArrayList;
import java.util.List;




public class ShipService {


    public static boolean deployShips(DeployShipsCommand command, Game game) {
        List<Ship> ships = buildShips(command);
        if (command.getPlayerId() == game.getPlayerOneId()) {
            //
        } else {
            //cargamos barcos p2
        }


        return false;
    }

    private static List<Ship> buildShips(DeployShipsCommand command) {
        List<Ship> shipList = new ArrayList<>();
        for(DeployShipsCommand.ShipDeployment shipDeployment : command.getShipsDeploy()) {
            Ship ship = ShipType.getByTypeName(shipDeployment.getShipType()).newInstance();
            ship.setCoordinates(mapStringToCoordinates(shipDeployment));
            shipList.add(ship);
           }
        return shipList;
    }

    private static List<Coordinate> mapStringToCoordinates(DeployShipsCommand.ShipDeployment shipDeployment) {
        CoordinateService coordinateService = new CoordinateService();
        List<Coordinate> coordinateList = new ArrayList<>();
        for(String coordinate: shipDeployment.getCoordinates()) {
           coordinateList.add(coordinateService.decodeCoordinate(coordinate));
        }
        return coordinateList;
    }
}
