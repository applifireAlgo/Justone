package com.app.server.businessservice.testproj1boundedcontext.proj;
import com.app.server.repository.testproj1boundedcontext.proj.ItemRepository;
import com.app.shared.testproj1boundedcontext.proj.Item;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Tstprjds {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private ItemRepository<Item> itemRepository;

    public void tstds(Item entity) throws Exception {
        entity.setTotal(entity.getPrice() * entity.getQuantity());
        com.app.shared.testproj1boundedcontext.proj.Item item1 = itemRepository.save(entity);
    }
}
