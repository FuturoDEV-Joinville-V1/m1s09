package br.futurodev.joiville.m1s09.services;

import br.futurodev.joiville.m1s09.dtos.customers.CustomerResponseDto;
import br.futurodev.joiville.m1s09.dtos.orders.OrderItemRequestDto;
import br.futurodev.joiville.m1s09.dtos.orders.OrderItemResponseDto;
import br.futurodev.joiville.m1s09.dtos.orders.OrderRequestDto;
import br.futurodev.joiville.m1s09.dtos.orders.OrderResponseDto;
import br.futurodev.joiville.m1s09.dtos.products.ProductResponseDto;
import br.futurodev.joiville.m1s09.entities.Customer;
import br.futurodev.joiville.m1s09.entities.Order;
import br.futurodev.joiville.m1s09.entities.OrderItem;
import br.futurodev.joiville.m1s09.entities.Product;
import br.futurodev.joiville.m1s09.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final ProductService productService;
    private final CustomerService customerService;

    public OrderServiceImpl(
            OrderRepository repository,
            ProductService productService,
            CustomerService customerService
    ) {
        this.repository = repository;
        this.productService = productService;
        this.customerService = customerService;
    }

    @Override
    public List<OrderResponseDto> findAll() {
        List<Order> orders = repository.findAll();
        List<OrderResponseDto> response = new ArrayList<>();

        for (Order order : orders) {
            OrderResponseDto orderResponse = new OrderResponseDto(
                    order.getId(),
                    new CustomerResponseDto(
                            order.getCustomer().getId(),
                            order.getCustomer().getName(),
                            order.getCustomer().getTaxId(),
                            order.getCustomer().getContact(),
                            order.getCustomer().getAddress()
                    ),
                    order.getTotalItems(),
                    order.getDiscount(),
                    order.getGrandTotal(),
                    new ArrayList<>()
            );

            for (OrderItem item : order.getItems()) {
                OrderItemResponseDto itemResponse = new OrderItemResponseDto(
                        item.getId(),
                        new ProductResponseDto(
                                item.getProduct().getId(),
                                item.getProduct().getName(),
                                item.getProduct().getDescription(),
                                item.getProduct().getSku(),
                                item.getProduct().getStockQuantity(),
                                item.getProduct().getPrice()
                        ),
                        item.getQuantity(),
                        item.getPrice(),
                        item.getTotal()
                );
                orderResponse.items().add(itemResponse);
            }

            response.add(orderResponse);
        }

        return response;
    }

    @Override
    public OrderResponseDto findById(Long id) {
        Order order = repository.findById(id).orElseThrow();
        OrderResponseDto orderResponse = new OrderResponseDto(
                order.getId(),
                new CustomerResponseDto(
                        order.getCustomer().getId(),
                        order.getCustomer().getName(),
                        order.getCustomer().getTaxId(),
                        order.getCustomer().getContact(),
                        order.getCustomer().getAddress()
                ),
                order.getTotalItems(),
                order.getDiscount(),
                order.getGrandTotal(),
                new ArrayList<>()
        );

        for (OrderItem item : order.getItems()) {
            OrderItemResponseDto itemResponse = new OrderItemResponseDto(
                    item.getId(),
                    new ProductResponseDto(
                            item.getProduct().getId(),
                            item.getProduct().getName(),
                            item.getProduct().getDescription(),
                            item.getProduct().getSku(),
                            item.getProduct().getStockQuantity(),
                            item.getProduct().getPrice()
                    ),
                    item.getQuantity(),
                    item.getPrice(),
                    item.getTotal()
            );
            orderResponse.items().add(itemResponse);
        }

        return orderResponse;
    }

    @Override
    public OrderResponseDto create(OrderRequestDto dto) {
        Order order = new Order();

        order.setDiscount(BigDecimal.ZERO);
        if (dto.discount() != null) {
            order.setDiscount(dto.discount());
        }

        order.setTotalItems(BigDecimal.ZERO);

        Customer customer = customerService.findEntityById(dto.customerId());
        order.setCustomer(customer);

        for (OrderItemRequestDto itemDto : dto.items()) {
            OrderItem item = new OrderItem();
            item.setOrder(order);

            item.setQuantity(BigDecimal.ONE);
            if (itemDto.quantity() != null) {
                item.setQuantity(itemDto.quantity());
            }

            Product product = productService.findEntityById(itemDto.productId());
            item.setProduct(product);
            item.setPrice(product.getPrice());

            item.setTotal(item.getQuantity().multiply(item.getPrice()));

            order.getItems().add(item);
            order.setTotalItems(order.getTotalItems().add(item.getTotal()));
        }

        order.setGrandTotal(order.getTotalItems().subtract(order.getDiscount()));

        order = repository.save(order);

        return findById(order.getId());
    }

    @Override
    public OrderResponseDto cancel(Long id) {
        // TODO
        return null;
    }
}
