package org.keycloak.broker.oidc;

import org.junit.Assert;
import org.junit.Test;
import org.keycloak.models.IdentityProviderModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.representations.JsonWebToken;
import org.keycloak.services.resteasy.ResteasyKeycloakSession;
import org.keycloak.services.resteasy.ResteasyKeycloakSessionFactory;
import org.keycloak.util.TokenUtil;

public class OIDCIdentityProviderTest {

    private KeycloakSession session = new ResteasyKeycloakSession(new ResteasyKeycloakSessionFactory());
    private IdentityProviderModel model = new IdentityProviderModel();
    private OIDCIdentityProvider identityProvider = new OIDCIdentityProvider(session, new OIDCIdentityProviderConfig(model));

    @Test
    public void testIsTokenTypeSupportedWtihBearerType() {
        JsonWebToken jsonWebToken = new JsonWebToken();
        jsonWebToken.type(TokenUtil.TOKEN_TYPE_BEARER);
        Assert.assertTrue(identityProvider.isTokenTypeSupported(jsonWebToken));
    }
    @Test
    public void testIsTokenTypeSupportedWithNullValue() {
        JsonWebToken jsonWebToken = new JsonWebToken();
        jsonWebToken.type(null);
        Assert.assertTrue(identityProvider.isTokenTypeSupported(jsonWebToken));
    }
}
