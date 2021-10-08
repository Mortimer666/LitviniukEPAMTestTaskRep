package parser;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RollingStockDOMParser {

    public static List<RollingStockRep> parseXML() {
        try {
            List<RollingStockRep> rollingStockInformation = new ArrayList<>();
            NodeList rollingStock = четыре_метод_выносишь();
            for (int i = 0; i < rollingStock.getLength(); i++) {
                Node locomotivesOrRailwayCarriage = rollingStock.item(i);
                if (locomotivesOrRailwayCarriage.getNodeType() == Node.TEXT_NODE) {
                    continue;
                }
                три_метод_выносишь(rollingStockInformation, locomotivesOrRailwayCarriage);
            }
            return rollingStockInformation;
        } catch (ParserConfigurationException | SAXException | IOException ex) { // Идею слушай
            ex.printStackTrace(); // зачем тебе system.out, ты и так в консоли все увидишь
            return new ArrayList<>();
        }
    }

    private static NodeList четыре_метод_выносишь() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse("resources/rolling_stock.xml");
        Node root = document.getDocumentElement();
        return root.getChildNodes();
    }

    private static void три_метод_выносишь(List<RollingStockRep> rollingStockInformation, Node locomotivesOrRailwayCarriage) {
        NodeList locomotiveOrRailwayCarriageTypes = locomotivesOrRailwayCarriage.getChildNodes();
        for (int j = 0; j < locomotiveOrRailwayCarriageTypes.getLength(); j++) {
            rollingStockInformation.add(new RollingStockRep());
            Node locomotiveOrRailwayCarriageType = locomotiveOrRailwayCarriageTypes.item(j);
            if (locomotiveOrRailwayCarriageType.getNodeType() == Node.TEXT_NODE) {
                continue;
            }
            два_метод_выносишь(rollingStockInformation, j, locomotiveOrRailwayCarriageType);
        }
    }

    private static void два_метод_выносишь(List<RollingStockRep> rollingStockInformation, int j, Node locomotiveOrRailwayCarriageType) {
        NodeList locomotiveOrRailwayCarriageProps = locomotiveOrRailwayCarriageType.getChildNodes();
        for (int k = 0; k < locomotiveOrRailwayCarriageProps.getLength(); k++) {
            Node locomotiveOrRailwayCarriageProp = locomotiveOrRailwayCarriageProps.item(k);
            if (locomotiveOrRailwayCarriageProp.getNodeType() == Node.TEXT_NODE) {
                continue;
            }
            раз_метод_выносишь(rollingStockInformation, j, locomotiveOrRailwayCarriageProp);
        }
    }

    private static void раз_метод_выносишь(List<RollingStockRep> rollingStockInformation, int j, Node locomotiveOrRailwayCarriageProp) {
        if (locomotiveOrRailwayCarriageProp.getNodeName().compareTo("id") == 0) {
            rollingStockInformation.get(j - 2).setId(locomotiveOrRailwayCarriageProp.getChildNodes().item(0).getTextContent());
        }
        if (locomotiveOrRailwayCarriageProp.getNodeName().compareTo("name") == 0) {
            rollingStockInformation.get(j - 2).setName(locomotiveOrRailwayCarriageProp.getChildNodes().item(0).getTextContent());
        }
        if (locomotiveOrRailwayCarriageProp.getNodeName().compareTo("type") == 0) {
            rollingStockInformation.get(j - 2).setType(locomotiveOrRailwayCarriageProp.getChildNodes().item(0).getTextContent());
        }
        if (locomotiveOrRailwayCarriageProp.getNodeName().compareTo("appointment") == 0) {
            rollingStockInformation.get(j - 2).setAppointment(locomotiveOrRailwayCarriageProp.getChildNodes().item(0).getTextContent());
        }
        if (locomotiveOrRailwayCarriageProp.getNodeName().compareTo("depot") == 0) {
            rollingStockInformation.get(j - 2).setDepot(Integer.parseInt(locomotiveOrRailwayCarriageProp.getChildNodes().item(0).getTextContent()));
        }
        if (locomotiveOrRailwayCarriageProp.getNodeName().compareTo("max_amount_of_cargo") == 0) {
            rollingStockInformation.get(j - 2).setMaximumAmountOfCargo(Integer.parseInt(locomotiveOrRailwayCarriageProp.getChildNodes().item(0).getTextContent()));
        }
        if (locomotiveOrRailwayCarriageProp.getNodeName().compareTo("number_of_seats") == 0) {
            rollingStockInformation.get(j - 2).setNumberOfSeats(Integer.parseInt(locomotiveOrRailwayCarriageProp.getChildNodes().item(0).getTextContent()));
        }
    }
}

