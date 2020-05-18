package com.manors.parkview.practicalunittesting.bl;

import com.manors.parkview.practicalunittesting.model.Client;

public interface TemplateEngine {
    String prepareMessage(Template template, Client client);

}
