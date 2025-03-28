module.exports = function(api) {
    api.cache(true);
    return {
      presets: ['babel-preset-expo'], // Use a configuração padrão do Expo
      plugins: ['react-native-reanimated/plugin'], // Adicione o plugin do Reanimated
    };
  };