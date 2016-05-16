package com.app.server.businessservice.testproj1boundedcontext.proj;
import com.app.server.repository.testproj1boundedcontext.proj.ItemRepository;
import com.app.shared.testproj1boundedcontext.proj.Item;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Dstst {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private ItemRepository<Item> itemRepository;

    public void dms(Item item) throws Exception {
        item.setTotal(item.caltotal());
        com.app.shared.testproj1boundedcontext.proj.Item item1 = itemRepository.save(item);
    }
}
