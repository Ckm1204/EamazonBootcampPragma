package com.Eamazon.Stock.domain.api;

import com.Eamazon.Stock.domain.model.request.ItemModelRequest;
import org.springframework.context.annotation.Bean;


public interface IitemServicePort {
    public void saveItem(ItemModelRequest itemdto);
}
