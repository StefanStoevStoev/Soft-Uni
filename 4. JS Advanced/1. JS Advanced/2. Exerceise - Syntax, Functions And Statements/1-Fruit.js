function fruinPrice(typeFruit, gramsFruit, price){

    let weight = gramsFruit / 1000;
    let finalWeight = weight.toFixed(2);
    let money = weight * price;
    let finalMoney = money.toFixed(2);

    console.log(`I need $${finalMoney} to buy ${finalWeight} kilograms ${typeFruit}.`);
}

fruinPrice('orange', 2500, 1.8);