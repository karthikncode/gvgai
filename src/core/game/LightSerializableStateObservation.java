package core.game;

import com.jsoniter.output.JsonStream;
import ontology.Types;

import java.util.ArrayList;
import java.util.HashMap;


public class LightSerializableStateObservation {
    public float gameScore;
    public int gameTick;
    public Types.WINNER gameWinner;
    public boolean isGameOver;
    public double[] worldDimension;
    public int blockSize;
    public float avatarSpeed;
    public double[] avatarOrientation;
    public Types.ACTIONS avatarLastAction;
    public int avatarType;
    public int avatarHealthPoints;
    public int avatarMaxHealthPoints;
    public int avatarLimitHealthPoints;
    public boolean isAvatarAlive;
    public ArrayList<Types.ACTIONS> availableActions;
    public HashMap<Integer, Integer> avatarResources;

    public LightSerializableStateObservation(ForwardModel s)
    {
        availableActions = s.getAvatarActions(false);
        gameScore = (float) s.getGameScore();
        gameTick = s.getGameTick();
        gameWinner = s.getGameWinner();
        isGameOver = s.isGameOver();

        worldDimension = new double[2];
        worldDimension[0] = s.getWorldDimension().getWidth();
        worldDimension[1] = s.getWorldDimension().getHeight();

        blockSize = s.getBlockSize();
        avatarSpeed = (float) s.getAvatarSpeed();

        avatarOrientation = new double[2];
        avatarOrientation[0] = s.getAvatarOrientation().x;
        avatarOrientation[1] = s.getAvatarOrientation().y;

        avatarResources = s.getAvatarResources();
        avatarLastAction = s.getAvatarLastAction();
        avatarType = s.getAvatarType();
        avatarHealthPoints = s.getAvatarHealthPoints();
        avatarMaxHealthPoints = s.getAvatarMaxHealthPoints();
        avatarLimitHealthPoints = s.getAvatarLimitHealthPoints();
        isAvatarAlive = s.isAvatarAlive();
    }

    public String serialize() {
        return JsonStream.serialize(this);
    }
}
