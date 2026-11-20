import com.google.gson.*;
import java.lang.reflect.Type;

public class CombatantDeserializer implements JsonDeserializer<Combatant> {

    @Override
    public Combatant deserialize(JsonElement json, Type typeOfT,
                                 JsonDeserializationContext context)
            throws JsonParseException {

        JsonObject object = json.getAsJsonObject();
        String type = object.get("type").getAsString();

        switch (type) {
            case "Boss Nob":
                return context.deserialize(json, BossNob.class);

            case "Boy":
                return context.deserialize(json, Boy.class);

            case "Space Marine Lieutenant":
                return context.deserialize(json, SpaceMarineLieutenant.class);

            case "Space Marine":
                return context.deserialize(json, SpaceMarine.class);

            case "Cadian Shock Trooper":
                return context.deserialize(json, CadianShockTrooper.class);

            case "LemanRussBattleTank":
                return context.deserialize(json, LemanRussBattleTank.class);

            default:
                throw new JsonParseException("Unknown combatant type: " + type);
        }
    }
}