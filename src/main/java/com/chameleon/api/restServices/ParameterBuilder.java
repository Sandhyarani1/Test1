package com.chameleon.api.restServices;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class ParameterBuilder {
    @SuppressWarnings("unused")
    private List<NameValuePair> params = new ArrayList<>();

    public ParameterBuilder() {
        this(new ParameterBuilder.Parameters());
    }

    private ParameterBuilder(ParameterBuilder.Parameters builder) {
        this.params = builder.params;
    }

    public static class Parameters {
        private List<NameValuePair> params;

        public Parameters() {
            params = new ArrayList<>();
        }

        public Parameters add(String key, Object value) {
            final String convertedObject = String.valueOf(value);
            if (key == null || key.length() == 0) {
                throw new IllegalArgumentException("ParameterBuilder.Builder.key (" + key + ") is null or empty.");
            }

            if (value == null || convertedObject.length() == 0) {
                throw new IllegalArgumentException("ParameterBuilder.Builder.value (" + convertedObject + ") is null or empty.");
            }

            this.params.add(new BasicNameValuePair(key, convertedObject));

            return this;
        }

        public List<NameValuePair> build() {
            return params;
        }
    }
}
