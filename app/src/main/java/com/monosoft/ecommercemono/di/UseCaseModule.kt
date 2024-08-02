package com.monosoft.ecommercemono.di


import com.monosoft.ecommercemono.domain.repository.AddressRepository
import com.monosoft.ecommercemono.domain.repository.AuthRepository
import com.monosoft.ecommercemono.domain.repository.CategoriesRepository
import com.monosoft.ecommercemono.domain.repository.MercadoPagoRepository
import com.monosoft.ecommercemono.domain.repository.OrdersRepository
import com.monosoft.ecommercemono.domain.repository.ProductsRepository
import com.monosoft.ecommercemono.domain.repository.ShoppingBagRepository
import com.monosoft.ecommercemono.domain.repository.UsersRepository
import com.monosoft.ecommercemono.domain.useCase.auth.AuthUseCase
import com.monosoft.ecommercemono.domain.useCase.auth.LoginUseCase
import com.monosoft.ecommercemono.domain.useCase.auth.RegisterUseCase
import com.monosoft.ecommercemono.domain.useCase.auth.UpdateSessionUseCase
import com.monosoft.ecommercemono.domain.useCase.categories.DeleteCategoryUseCase
import com.monosoft.ecommercemono.domain.useCase.categories.GetCategoriesUseCase
import com.monosoft.ecommercemono.domain.useCase.mercadopago.GetInstallmentsUseCase
import com.monosoft.ecommercemono.domain.useCase.mercadopago.MercadoPagoUseCase
import com.monosoft.ecommercemono.domain.useCase.products.CreateProductUseCase
import com.monosoft.ecommercemono.domain.useCase.products.DeleteProductUseCase
import com.monosoft.ecommercemono.domain.useCase.products.FindByCategoryUseCase
import com.monosoft.ecommercemono.domain.useCase.products.ProductsUseCase
import com.monosoft.ecommercemono.domain.useCase.products.UpdateProductUseCase
import com.monosoft.ecommercemono.domain.useCase.products.UpdateProductWithImageUseCase
import com.monosoft.ecommercemono.domain.useCase.users.UsersUseCase
import com.monosoft.ecommercemono.domain.useCase.address.AddressUseCase
import com.monosoft.ecommercemono.domain.useCase.address.CreateAddressUseCase
import com.monosoft.ecommercemono.domain.useCase.address.FindByUserAddressUseCase
import com.monosoft.ecommercemono.domain.useCase.auth.DeleteAccountUseCase
import com.monosoft.ecommercemono.domain.useCase.auth.GetSessionDataUseCase
import com.monosoft.ecommercemono.domain.useCase.auth.LogoutSessionUseCase
import com.monosoft.ecommercemono.domain.useCase.auth.SaveSessionUseCase
import com.monosoft.ecommercemono.domain.useCase.categories.CategoriesUseCase
import com.monosoft.ecommercemono.domain.useCase.categories.CreateCategoryUseCase
import com.monosoft.ecommercemono.domain.useCase.categories.UpdateCategoryUseCase
import com.monosoft.ecommercemono.domain.useCase.categories.UpdateCategoryWithImageUseCase
import com.monosoft.ecommercemono.domain.useCase.mercado_pago.CreateCardTokenUseCase
import com.monosoft.ecommercemono.domain.useCase.mercado_pago.CreatePaymentUseCase
import com.monosoft.ecommercemono.domain.useCase.orders.FindAllOrdersUseCase
import com.monosoft.ecommercemono.domain.useCase.orders.FindByClientOrdersUseCase
import com.monosoft.ecommercemono.domain.useCase.orders.OrdersUseCase
import com.monosoft.ecommercemono.domain.useCase.orders.UpdateStatusOrdersUseCase
import com.monosoft.ecommercemono.domain.useCase.products.FindAllUseCase
import com.monosoft.ecommercemono.domain.useCase.products.FindByNameUseCase
import com.monosoft.ecommercemono.domain.useCase.shopping_bag.AddUseCase
import com.monosoft.ecommercemono.domain.useCase.shopping_bag.DeleteUseCase
import com.monosoft.ecommercemono.domain.useCase.shopping_bag.FindAllShoppingBagUseCase
import com.monosoft.ecommercemono.domain.useCase.shopping_bag.FindByIdShoppingBagUseCase
import com.monosoft.ecommercemono.domain.useCase.shopping_bag.GetTotalUseCase
import com.monosoft.ecommercemono.domain.useCase.shopping_bag.ShoppingBagUseCase
import com.monosoft.ecommercemono.domain.useCase.users.UpdateUserUseCase
import com.monosoft.ecommercemono.domain.useCase.users.UpdateUserWithImageUseCase
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
        updateSession = UpdateSessionUseCase(authRepository),
        deleteAccountUseCase = DeleteAccountUseCase(authRepository)
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