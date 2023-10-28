package taxislibres.jeffrey.maestre.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import taxislibres.jeffrey.maestre.models.Bill;
import taxislibres.jeffrey.maestre.repositorys.BillRepository;
import taxislibres.jeffrey.maestre.services.IBillService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BillController {
    @Autowired
    private IBillService billService;

    private final BillRepository billRepository;

    @Autowired
    public BillController(BillRepository billRepository){
        this.billRepository = billRepository;
    }

    @GetMapping("/bill")
    public List<Bill> index(){
        return billRepository.findAll();
    }

    @GetMapping("/bill/{id}")
    public ResponseEntity<?> show(@PathVariable Long id){
        Bill bill = billRepository.findById(id).orElse(null);
        if(bill != null){
            return ResponseEntity.ok(bill);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/bill")
    public ResponseEntity<Bill> create (@Valid @RequestBody Bill bill){
        Bill createBill = billRepository.save(bill);
        return ResponseEntity.status(HttpStatus.CREATED).body(createBill);
    }

    @PatchMapping("/bill/{id}")
    public ResponseEntity<Bill> updatePartial (@Valid @RequestBody Bill bill, @PathVariable Long id){
        Bill billActualizado =  billService.update(bill);
        if (billActualizado != null){
            return ResponseEntity.ok(billActualizado);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/bill/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        billService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
