package Bus;

import jvocab.jixa.com.jvocab.Interfaces.BusResponse;

/**
 * Created by root on 9/18/15.
 */
public class HostActivityResponse implements BusResponse {
    private String id;

    public HostActivityResponse(String id) {
        this.id = id;
    }

    @Override
    public String getResponseID() {
        return this.id;
    }

}
