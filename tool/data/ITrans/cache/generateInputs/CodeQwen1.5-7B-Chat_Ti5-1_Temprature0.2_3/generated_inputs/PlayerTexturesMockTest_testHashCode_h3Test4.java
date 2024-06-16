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

class PlayerTexturesMockTest_testHashCode_h3Test4 {

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
    void testHashCode_h3Test4() throws MalformedURLException {
        // Assert that they both result into the same hashCode
    PlayerTexturesMock playerTexturesMock = new PlayerTexturesMock(profile);
    playerTexturesMock.setSkin(new URL("invalid_url"));
    PlayerTexturesMock otherPlayerTexturesMock = new PlayerTexturesMock(profile);
    otherPlayerTexturesMock.setSkin(new URL("invalid_url"));
        Assertions.assertEquals(playerTexturesMock.hashCode(), otherPlayerTexturesMock.hashCode());
    }
}
