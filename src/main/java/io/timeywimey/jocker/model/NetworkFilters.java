package io.timeywimey.jocker.model;

import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:nicolas.deloof@gmail.com">Nicolas De Loof</a>
 */
public class NetworkFilters {

    /* The API filter type is golang `map[string]map[string]bool` ¯\_(ツ)_/¯ */
    private Map<String, Map<String, Boolean>> args = new HashMap<>();

    private void add(String key, String value) {
        Map<String, Boolean> entry = args.get(key);
        if (entry == null) {
            entry = new HashMap<>();
            args.put(key, entry);
        }
        entry.put(value, true);
    }

    public void setDangling(boolean dangling) {
        add("dangling", String.valueOf(dangling));
    }

    public void setDriver(String driver) {
        add("driver", driver);
    }

    public void setLabel(String label) {
        add("label", label);
    }

    public void setName(String name) {
        add("name", name);
    }

    public void setId(String name) {
        add("id", name);
    }

    public void setScope(String scope) {
        add("scope", scope);
    }

    public void setType(String type) {
        add("type", type);
    }

    public NetworkFilters dangling(boolean dangling) {
        setDangling(dangling);
        return this;
    }

    public NetworkFilters driver(String driver) {
        setDriver(driver);
        return this;
    }

    public NetworkFilters label(String label) {
        setLabel(label);
        return this;
    }

    public NetworkFilters name(String name) {
        setName(name);
        return this;
    }

    public NetworkFilters id(String id) {
        setId(id);
        return this;
    }

    public NetworkFilters scope(String scope) {
        setScope(scope);
        return this;
    }

    public NetworkFilters type(String type) {
        setType(type);
        return this;
    }

    public String encode(Gson gson) {
        try {
            return URLEncoder.encode(gson.toJson(args), StandardCharsets.ISO_8859_1.name());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("This Java runtime does not support ISO_8859_1", e);
        }
    }
}
