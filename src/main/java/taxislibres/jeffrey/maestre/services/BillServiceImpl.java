package taxislibres.jeffrey.maestre.services;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taxislibres.jeffrey.maestre.models.Bill;
import taxislibres.jeffrey.maestre.repositorys.BillRepository;

import java.util.List;

@Service
public class BillServiceImpl implements IBillService{

    @Autowired
    BillRepository billRepository;
    @Override
    public Bill save(@Valid Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public Bill update(@Valid Bill bill) {
        Bill billActual =  billRepository.findById(bill.getId()).orElse(null);
        if(billActual == null){
            return null;
        }
        billActual.setUser(bill.getUser());
        billActual.setDesc(bill.getDesc());
        billActual.setTotalAmount(bill.getTotalAmount());
        return billRepository.save(billActual);
    }

    @Override
    public void delete(Long id) {
        billRepository.deleteById(id);
    }

    @Override
    public List<Bill> findAll() {
        return billRepository.findAll();
    }

    @Override
    public Bill findById(Long id) {
        return billRepository.findById(id).orElse(null);
    }
}
