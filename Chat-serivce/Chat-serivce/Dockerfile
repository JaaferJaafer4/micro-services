FROM mcr.microsoft.com/dotnet/aspnet:6.0 AS base
WORKDIR /app
EXPOSE 80
EXPOSE 443

FROM mcr.microsoft.com/dotnet/sdk:6.0 AS build
WORKDIR /src
COPY ["Chat-serivce/Chat-serivce.csproj", "Chat-serivce/"]
RUN dotnet restore "Chat-serivce/Chat-serivce.csproj"
COPY . .
WORKDIR "/src/Chat-serivce"
RUN dotnet build "Chat-serivce.csproj" -c Release -o /app/build

FROM build AS publish
RUN dotnet publish "Chat-serivce.csproj" -c Release -o /app/publish /p:UseAppHost=false

FROM base AS final
WORKDIR /app
COPY --from=publish /app/publish .
ENTRYPOINT ["dotnet", "Chat-serivce.dll"]
