package be.seeseemelk.mockbukkit.profile;

import be.seeseemelk.mockbukkit.profile.PlayerTexturesMock;
import be.seeseemelk.mockbukkit.profile.PlayerTexturesMock.*;
import be.seeseemelk.mockbukkit.MockBukkit;
import org.bukkit.profile.PlayerTextures.SkinModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import be.seeseemelk.mockbukkit.profile.PlayerProfileMock;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

class PlayerTexturesMockTest_testHashCode_h1Test1 {

    private static PlayerProfileMock profile;

    @BeforeEach
    void setUp() {
        MockBukkit.mock();
        profile = new PlayerProfileMock("Test", UUID.randomUUID());
    }

    @AfterEach
    void teardown() {
        MockBukkit.unmock();
    }

    @Test
    void testHashCode_h1Test1() throws MalformedURLException {
        // Assert that they both result into the same hashCode
    PlayerTexturesMock playerTexturesMock = new PlayerTexturesMock(profile);
    playerTexturesMock.setSkin(new URL("https://github.com/skin"));
    ProfileProperty property = new ProfileProperty("textures", "value", "signature");
    playerTexturesMock.setProperty(property);
    PlayerTexturesMock otherPlayerTexturesMock = new PlayerTexturesMock(profile);
    otherPlayerTexturesMock.setSkin(new URL("https://github.com/skin"));
    otherPlayerTexturesMock.setProperty(property);
        Assertions.assertEquals(playerTexturesMock.hashCode(), otherPlayerTexturesMock.hashCode());
    }
}

