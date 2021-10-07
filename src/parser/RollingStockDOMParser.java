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
        List<RollingStockRep> rollingStockInformation = new ArrayList<>();
        int counter = 0;
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("resources/rolling_stock.xml");
            Node root = document.getDocumentElement();
            NodeList rollingStock = root.getChildNodes();
            for (int i = 0; i < rollingStock.getLength(); i++) {
                Node locomotivesOrRailwayCarriage = rollingStock.item(i);
                if (locomotivesOrRailwayCarriage.getNodeType() != Node.TEXT_NODE) {
                    NodeList locomotiveOrRailwayCarriageTypes = locomotivesOrRailwayCarriage.getChildNodes();
                    for (int j = 0; j < locomotiveOrRailwayCarriageTypes.getLength(); j++) {
                        counter++;
                        rollingStockInformation.add(new RollingStockRep());
                        Node locomotiveOrRailwayCarriageType = locomotiveOrRailwayCarriageTypes.item(j);
                        if (locomotiveOrRailwayCarriageType.getNodeType() != Node.TEXT_NODE) {
                            NodeList locomotiveOrRailwayCarriageProps = locomotiveOrRailwayCarriageType.getChildNodes();
                            for (int k = 0; k < locomotiveOrRailwayCarriageProps.getLength(); k++) {
                                Node locomotiveOrRailwayCarriageProp = locomotiveOrRailwayCarriageProps.item(k);
                                if (locomotiveOrRailwayCarriageProp.getNodeType() != Node.TEXT_NODE) {
                                    if (locomotiveOrRailwayCarriageProp.getNodeName().compareTo("id") == 0) {
                                        rollingStockInformation.get(counter - 2).setId(locomotiveOrRailwayCarriageProp.getChildNodes().item(0).getTextContent());
                                    }
                                    if (locomotiveOrRailwayCarriageProp.getNodeName().compareTo("name") == 0) {
                                        rollingStockInformation.get(counter - 2).setName(locomotiveOrRailwayCarriageProp.getChildNodes().item(0).getTextContent());
                                    }
                                    if (locomotiveOrRailwayCarriageProp.getNodeName().compareTo("type") == 0) {
                                        rollingStockInformation.get(counter - 2).setType(locomotiveOrRailwayCarriageProp.getChildNodes().item(0).getTextContent());
                                    }
                                    if (locomotiveOrRailwayCarriageProp.getNodeName().compareTo("appointment") == 0) {
                                        rollingStockInformation.get(counter - 2).setAppointment(locomotiveOrRailwayCarriageProp.getChildNodes().item(0).getTextContent());
                                    }
                                    if (locomotiveOrRailwayCarriageProp.getNodeName().compareTo("depot") == 0) {
                                        rollingStockInformation.get(counter - 2).setDepot(Integer.parseInt(locomotiveOrRailwayCarriageProp.getChildNodes().item(0).getTextContent()));
                                    }
                                    if (locomotiveOrRailwayCarriageProp.getNodeName().compareTo("max_amount_of_cargo") == 0) {
                                        rollingStockInformation.get(counter - 2).setMaximumAmountOfCargo(Integer.parseInt(locomotiveOrRailwayCarriageProp.getChildNodes().item(0).getTextContent()));
                                    }
                                    if (locomotiveOrRailwayCarriageProp.getNodeName().compareTo("number_of_seats") == 0) {
                                        rollingStockInformation.get(counter - 2).setNumberOfSeats(Integer.parseInt(locomotiveOrRailwayCarriageProp.getChildNodes().item(0).getTextContent()));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return rollingStockInformation;
    }
}

