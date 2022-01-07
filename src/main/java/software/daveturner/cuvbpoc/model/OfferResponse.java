package software.daveturner.cuvbpoc.model;

public enum OfferResponse {
    ACCEPT, DECLINE, DEFER;

    public static boolean isValidResponse(String s) {
        return (s.equals(ACCEPT.toString()) || s.equals(DECLINE.toString()) || s.equals(DEFER.toString()));
    }

}
