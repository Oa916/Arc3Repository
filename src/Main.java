import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import com.google.gson.*;


public class Main {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();


    private final ArrayList<Combatant> orks = new ArrayList<>();
    private final ArrayList<Combatant> spaceMarines = new ArrayList<>();
    private final ArrayList<Combatant> guards = new ArrayList<>();

    private String selectedFaction;

    private final JLabel selectionLabel =
            new JLabel("No faction selected");

    private final JTextArea rosterDisplay =
            new JTextArea(7, 28);

    public Main() {
        createRosterSublists();
    }

    private void createRosterSublists() {

        // Orks
        orks.add(new BossNob(
                "Boss Nob", "Guz", 2, 2,
                "Kombi-weapon", 4, "Ork",
                "Power Klaw", 9
        ));

        orks.add(new Boy(
                "Boy", "Grunt", 2, 2,
                "Slugga", 4, "Ork"
        ));

        // Space Marines
        spaceMarines.add(new SpaceMarineLieutenant(
                "Space Marine Lieutenant", "Lieutenant John",
                4, 4, "Heavy bolt pistol", 4,
                "Human-SpaceMarine", "Power fist", 8
        ));

        spaceMarines.add(new SpaceMarine(
                "Space Marine", "Marine David",
                4, 2, "Bolt Rifle", 5,  "Human-SpaceMarine"
        ));

        // Imperial Guard
        guards.add(new CadianShockTrooper(
                "Cadian Shock Trooper", "Trooper Daniel",
                3, 1, "Flamer", 4,
                "Human-Guardsman"
        ));
        guards.add(new LemanRussBattleTank("LemanRussBattleTank", "Leman Russ Battle Tank",
                8,13,"Leman Russ Battle Cannon", 10, "Astra Militarum"));

    }

    private void showGui() {

        JFrame frame = new JFrame("Faction Selection");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 320);
        frame.setLocationRelativeTo(null);

        JLabel prompt = new JLabel("Choose your faction:");

        String[] factions = {
                "Orks",
                "SpaceMarines",
                "Guards"
        };

        JComboBox<String> factionPicker =
                new JComboBox<>(factions);

        JButton selectButton =
                new JButton("Select Faction");

        rosterDisplay.setEditable(false);
        rosterDisplay.setLineWrap(true);
        rosterDisplay.setWrapStyleWord(true);

        selectButton.addActionListener(event -> {

            selectedFaction =
                    (String) factionPicker.getSelectedItem();

            ArrayList<Combatant> chosenRoster =
                    getFactionRoster(selectedFaction);

            selectionLabel.setText(
                    "Selected faction: " + selectedFaction
            );

            rosterDisplay.setText(
                    "Members in this faction:\n\n"
            );

            for (Combatant combatant : chosenRoster) {
                rosterDisplay.append(
                        "• " + combatant.getName() + "\n"
                );
            }
        });

        JPanel topPanel =
                new JPanel(new FlowLayout(FlowLayout.LEFT));

        topPanel.add(prompt);
        topPanel.add(factionPicker);
        topPanel.add(selectButton);

        JPanel content =
                new JPanel(new BorderLayout(10, 10));

        content.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        content.add(topPanel, BorderLayout.NORTH);
        content.add(
                new JScrollPane(rosterDisplay),
                BorderLayout.CENTER
        );
        content.add(selectionLabel, BorderLayout.SOUTH);

        frame.setContentPane(content);
        frame.setVisible(true);
    }

    private ArrayList<Combatant> getFactionRoster(String faction) {

        switch (faction) {

            case "Orks":
                return orks;

            case "SpaceMarines":
                return spaceMarines;

            case "Guards":
                return guards;

            default:
                return new ArrayList<>();
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() ->
                new Main().showGui()

        );
    }
}