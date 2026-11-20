import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import com.google.gson.*;
import java.io.FileReader;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

public class Main {

    Gson gson = new GsonBuilder()
            .registerTypeAdapter(Combatant.class, new CombatantDeserializer())
            .setPrettyPrinting()
            .create();


    private final ArrayList<Combatant> orks = new ArrayList<>();
    private final ArrayList<Combatant> spaceMarines = new ArrayList<>();
    private final ArrayList<Combatant> guards = new ArrayList<>();

    private String selectedFaction;

    private final JLabel selectionLabel =
            new JLabel("No faction selected");

    private final JTextArea rosterDisplay =
            new JTextArea(7, 28);

    private void createRosterSublists() {

        try {
            JsonObject data = JsonParser.parseReader(
                    new FileReader("units.json")
            ).getAsJsonObject();

            Type combatantListType =
                    new TypeToken<ArrayList<Combatant>>() {}.getType();

            // Orks
            orks.addAll(gson.fromJson(
                    data.getAsJsonArray("orks"),
                    combatantListType
            ));

            // Space Marines
            spaceMarines.addAll(gson.fromJson(
                    data.getAsJsonArray("spaceMarines"),
                    combatantListType
            ));

            // Imperial Guard
            guards.addAll(gson.fromJson(
                    data.getAsJsonArray("guards"),
                    combatantListType
            ));

        } catch (Exception e) {
            e.printStackTrace();
        }
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