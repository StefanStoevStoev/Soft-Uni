package com.example.battleships.service;

import com.example.battleships.model.DTO.ShipDTO;
import com.example.battleships.model.entity.CategoryEntity;
import com.example.battleships.model.entity.ShipEntity;
import com.example.battleships.model.entity.UserEntity;
import com.example.battleships.model.service.ShipFireServiceModel;
import com.example.battleships.model.view.ShipListViewModel;
import com.example.battleships.repository.ShipRepository;
import com.example.battleships.repository.UserRepository;
import com.example.battleships.session.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShipService {

    private final ModelMapper modelMapper;
    private final ShipRepository shipRepository;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;
    private final UserRepository userRepository;

    public ShipService(ModelMapper modelMapper,
                       ShipRepository shipRepository,
                       CurrentUser currentUser, UserService userService, CategoryService categoryService, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.shipRepository = shipRepository;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
        this.userRepository = userRepository;
    }

    public boolean registrationShip(ShipDTO shipDTO){
        ShipEntity ship = modelMapper.map(shipDTO, ShipEntity.class);

        UserEntity user = this.userService
                .getCurrentUser()
                .orElseThrow(() ->
                        new  IllegalArgumentException(String.format("User %s not found",
                                this.userService.getCurrentUser().get().getUsername())));

        CategoryEntity category = this.categoryService.
                findCategoryByName(shipDTO.getCategory()).orElseThrow(() ->
                        new IllegalArgumentException(String.format("Category %s not found",
                                shipDTO.getCategory())));

        ship.setUser(user);
        ship.setCategory(category);

        this.shipRepository.save(ship);
        return true;
    }

    public void fire(ShipFireServiceModel serviceModel){

        ShipEntity attacker = this.shipRepository.findById(serviceModel.getAttackerId()).orElse(null);
        ShipEntity defender = this.shipRepository.findById(serviceModel.getDefenderId()).orElse(null);

        assert defender != null;
        assert attacker != null;
        defender.setHealth(defender.getHealth() - attacker.getPower());

        if(defender.getHealth() <= 0){
            this.shipRepository.delete(defender);
        }else {
            this.shipRepository.save(defender);
        }
    }

    public Optional<ShipEntity> findByName(String shipName){
        return this.shipRepository.findByName(shipName);
    }
    public ShipListViewModel getAllShips() {
        return new ShipListViewModel(this.shipRepository.findAllShips(), this.userService.getCurrentUserName());
    }
}
