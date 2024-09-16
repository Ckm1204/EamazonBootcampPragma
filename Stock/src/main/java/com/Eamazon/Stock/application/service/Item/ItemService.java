package com.Eamazon.Stock.application.service.Item;

import com.Eamazon.Stock.application.dto.request.ItemRequestDTO;
import com.Eamazon.Stock.application.dto.response.ItemResponseDTO;
import com.Eamazon.Stock.application.mapper.ItemMapper;
import com.Eamazon.Stock.domain.api.IitemServicePort;
import com.Eamazon.Stock.domain.model.request.ItemModelRequest;
import com.Eamazon.Stock.domain.model.response.ItemModelResponse;
import com.Eamazon.Stock.domain.model.response.ItemModelResponse;
import com.Eamazon.Stock.domain.paginate.NameSortingStrategy;
import com.Eamazon.Stock.domain.paginate.PaginatedResponse;
import com.Eamazon.Stock.domain.paginate.Paginator;
import com.Eamazon.Stock.domain.paginate.SimplePaginationStrategy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ItemService implements IItemService{


    private final IitemServicePort iItemServicePort;
    private final ItemMapper mapper;


    @Override
    public void saveItem(ItemRequestDTO itemdto) {
        ItemModelRequest itemModelRequest = mapper.toItemModel(itemdto);
        iItemServicePort.saveItem(itemModelRequest);
    }

    @Override
    public List<ItemResponseDTO> getAllItems() {
        List<ItemModelResponse> items = iItemServicePort.getAllItems();
        return mapper.toItemDTOs(items);
    }

    @Override
    public List<ItemResponseDTO> getItemsByNameContaining(String name) {
        List<ItemModelResponse> items = iItemServicePort.getItemsByNameContaining(name);
        return mapper.toItemDTOs(items);
    }

    @Override
    public List<ItemResponseDTO> getItemsByBrandName(String brandName) {
        List<ItemModelResponse> items = iItemServicePort.getItemsByBrandName(brandName);
        return mapper.toItemDTOs(items);
    }

    @Override
    public List<ItemResponseDTO> getItemsByCategoryName(String categoryName) {
        List<ItemModelResponse> items = iItemServicePort.getItemsByCategoryName(categoryName);
        return mapper.toItemDTOs(items);
    }

    public PaginatedResponse<ItemModelResponse> getPaginatedAndSortedItems(Integer page, Integer size, boolean ascending,List<ItemResponseDTO> items ) {
        List<ItemModelResponse> allItems = mapper.toItemModelsResponse(items);
        Paginator<ItemModelResponse> paginator = new Paginator<>(new SimplePaginationStrategy<>(), new NameSortingStrategy());
        List<ItemModelResponse> paginatedItems = paginator.paginateAndSort(allItems, page, size, ascending);
        int totalElements = allItems.size();
        int totalPages = (int) Math.ceil((double) totalElements / size);
        return new PaginatedResponse<>(paginatedItems, page, size, totalElements, totalPages);
    }


}
