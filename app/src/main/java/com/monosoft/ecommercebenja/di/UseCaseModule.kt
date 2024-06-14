package com.monosoft.ecommercebenja.di


import com.monosoft.ecommercebenja.domain.repository.AddressRepository
import com.monosoft.ecommercebenja.domain.repository.AuthRepository
import com.monosoft.ecommercebenja.domain.repository.CategoriesRepository
import com.monosoft.ecommercebenja.domain.repository.MercadoPagoRepository
import com.monosoft.ecommercebenja.domain.repository.OrdersRepository
import com.monosoft.ecommercebenja.domain.repository.ProductsRepository
import com.monosoft.ecommercebenja.domain.repository.ShoppingBagRepository
import com.monosoft.ecommercebenja.domain.repository.UsersRepository
import com.monosoft.ecommercebenja.domain.useCase.auth.AuthUseCase
import com.monosoft.ecommercebenja.domain.useCase.auth.LoginUseCase
import com.monosoft.ecommercebenja.domain.useCase.auth.RegisterUseCase
import com.monosoft.ecommercebenja.domain.useCase.auth.UpdateSessionUseCase
import com.monosoft.ecommercebenja.domain.useCase.categories.DeleteCategoryUseCase
import com.monosoft.ecommercebenja.domain.useCase.categories.GetCategoriesUseCase
import com.monosoft.ecommercebenja.domain.useCase.mercadopago.GetInstallmentsUseCase
import com.monosoft.ecommercebenja.domain.useCase.mercadopago.MercadoPagoUseCase
import com.monosoft.ecommercebenja.domain.useCase.products.CreateProductUseCase
import com.monosoft.ecommercebenja.domain.useCase.products.DeleteProductUseCase
import com.monosoft.ecommercebenja.domain.useCase.products.FindByCategoryUseCase
import com.monosoft.ecommercebenja.domain.useCase.products.ProductsUseCase
import com.monosoft.ecommercebenja.domain.useCase.products.UpdateProductUseCase
import com.monosoft.ecommercebenja.domain.useCase.products.UpdateProductWithImageUseCase
import com.monosoft.ecommercebenja.domain.useCase.users.UsersUseCase
import com.monosoft.ecommercebenja.domain.useCase.address.AddressUseCase
import com.monosoft.ecommercebenja.domain.useCase.address.CreateAddressUseCase
import com.monosoft.ecommercebenja.domain.useCase.address.FindByUserAddressUseCase
import com.monosoft.ecommercebenja.domain.useCase.auth.GetSessionDataUseCase
import com.monosoft.ecommercebenja.domain.useCase.auth.LogoutSessionUseCase
import com.monosoft.ecommercebenja.domain.useCase.auth.SaveSessionUseCase
import com.monosoft.ecommercebenja.domain.useCase.categories.CategoriesUseCase
import com.monosoft.ecommercebenja.domain.useCase.categories.CreateCategoryUseCase
import com.monosoft.ecommercebenja.domain.useCase.categories.UpdateCategoryUseCase
import com.monosoft.ecommercebenja.domain.useCase.categories.UpdateCategoryWithImageUseCase
import com.monosoft.ecommercebenja.domain.useCase.mercado_pago.CreateCardTokenUseCase
import com.monosoft.ecommercebenja.domain.useCase.mercado_pago.CreatePaymentUseCase
import com.monosoft.ecommercebenja.domain.useCase.orders.FindAllOrdersUseCase
import com.monosoft.ecommercebenja.domain.useCase.orders.FindByClientOrdersUseCase
import com.monosoft.ecommercebenja.domain.useCase.orders.OrdersUseCase
import com.monosoft.ecommercebenja.domain.useCase.orders.UpdateStatusOrdersUseCase
import com.monosoft.ecommercebenja.domain.useCase.products.FindAllUseCase
import com.monosoft.ecommercebenja.domain.useCase.products.FindByNameUseCase
import com.monosoft.ecommercebenja.domain.useCase.shopping_bag.AddUseCase
import com.monosoft.ecommercebenja.domain.useCase.shopping_bag.DeleteUseCase
import com.monosoft.ecommercebenja.domain.useCase.shopping_bag.FindAllShoppingBagUseCase
import com.monosoft.ecommercebenja.domain.useCase.shopping_bag.FindByIdShoppingBagUseCase
import com.monosoft.ecommercebenja.domain.useCase.shopping_bag.GetTotalUseCase
import com.monosoft.ecommercebenja.domain.useCase.shopping_bag.ShoppingBagUseCase
import com.monosoft.ecommercebenja.domain.useCase.users.UpdateUserUseCase
import com.monosoft.ecommercebenja.domain.useCase.users.UpdateUserWithImageUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
        login = LoginUseCase(authRepository),
        register = RegisterUseCase(authRepository),
        saveSession = SaveSessionUseCase(authRepository),
        getSessionData = GetSessionDataUseCase(authRepository),
        logout = LogoutSessionUseCase(authRepository),
        updateSession = UpdateSessionUseCase(authRepository)
    )

    @Provides
    fun provideUsersUseCase(usersRepository: UsersRepository) = UsersUseCase(
        updateUser = UpdateUserUseCase(usersRepository),
        updateUserWithImage = UpdateUserWithImageUseCase(usersRepository)
    )

    @Provides
    fun provideCategoriesUseCase(categoriesRepository: CategoriesRepository) = CategoriesUseCase(
        createCategory = CreateCategoryUseCase(categoriesRepository),
        getCategories = GetCategoriesUseCase(categoriesRepository),
        updateCategory = UpdateCategoryUseCase(categoriesRepository),
        updateCategoryWithImage = UpdateCategoryWithImageUseCase(categoriesRepository),
        deleteCategory = DeleteCategoryUseCase(categoriesRepository)
    )

    @Provides
    fun provideProductsUseCase(productsRepository: ProductsRepository) = ProductsUseCase(
        createProduct = CreateProductUseCase(productsRepository),
        findByCategory = FindByCategoryUseCase(productsRepository),
        findAll = FindAllUseCase(productsRepository),
        updateProduct = UpdateProductUseCase(productsRepository),
        updateProductWithImage = UpdateProductWithImageUseCase(productsRepository),
        deleteProduct = DeleteProductUseCase(productsRepository),
        findByName = FindByNameUseCase(productsRepository)
    )

    @Provides
    fun provideShoppingBagUseCase(shoppingBagRepository: ShoppingBagRepository) = ShoppingBagUseCase(
        add = AddUseCase(shoppingBagRepository),
        delete = DeleteUseCase(shoppingBagRepository),
        findAll = FindAllShoppingBagUseCase(shoppingBagRepository),
        findById = FindByIdShoppingBagUseCase(shoppingBagRepository),
        getTotal = GetTotalUseCase(shoppingBagRepository)
    )

    @Provides
    fun provideAddressUseCase(addressRepository: AddressRepository) = AddressUseCase(
        createAddress = CreateAddressUseCase(addressRepository),
        findByUserAddress = FindByUserAddressUseCase(addressRepository)
    )

    @Provides
    fun provideMercadoPagoUseCase(mercadoPagoRepository: MercadoPagoRepository) = MercadoPagoUseCase(
        //getIdentificationType = GetIdentificationTypeUseCase(mercadoPagoRepository),
        getInstallments = GetInstallmentsUseCase(mercadoPagoRepository),
        createCardToken = CreateCardTokenUseCase(mercadoPagoRepository),
        createPayment = CreatePaymentUseCase(mercadoPagoRepository),
    )

    @Provides
    fun provideOrdersUseCase(ordersRepository: OrdersRepository) = OrdersUseCase(
        findAllOrders = FindAllOrdersUseCase(ordersRepository),
        findByClientOrders = FindByClientOrdersUseCase(ordersRepository),
        updateStatusOrders = UpdateStatusOrdersUseCase(ordersRepository)
    )
}