package in.huzaifa.cloudshareapi.security;



import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

@Component
public class ClerkJwksProvider {

    @Value("${clerk.jwks-url}")
    private String jwksUrl;

    private final Map<String, PublicKey> keyCache = new HashMap<>();
    private long lastFechTime = 0;
    private static final long CACHE_TTL = 36000000; // 1 HOUR


    public PublicKey getPublicKey(String kid) throws Exception{
        if (keyCache.containsKey(kid) && System.currentTimeMillis() - lastFechTime < CACHE_TTL){
            return keyCache.get(kid);
        }

        refreshKey();
        return keyCache.get(kid);
    }

//    private void refreshKey() throws Exception {
//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode jwks = mapper.readTree( new URL(jwksUrl) );
//
//
//        JsonNode keys = jwks.get("keys");
//    }


}
